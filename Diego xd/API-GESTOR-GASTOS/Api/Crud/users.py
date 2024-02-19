import sys # Mandar mensajes de error al log

from Api.Models.User import User
from fastapi import HTTPException
from Api.Schemas.users import UserCreate,UserRead, UserUpdateAdmin #,UserUpdateAdmin,UserDelete,UserDeleteAdmin
from sqlalchemy.orm import Session
from sqlalchemy import update
from Core.security import get_hashed_password,verify_password
from Core.utils import generate_user_id

def create_new_user(user:UserCreate,rol:str,db:Session):
    db_user = User(
        user_id = generate_user_id(),
        full_name = user.full_name,
        mail = user.mail,
        passhash = get_hashed_password(user.passhash),
        user_role = rol,
        user_status = user.user_status
    )

    try:
        db.add(db_user)
        db.commit()
        db.refresh(db_user)
        db.close()
        return db_user
    except Exception as e :
        db.rollback()
        # Imprimir el error en la consola
        print(f"Error al crear un usuario: {str(e)}",file=sys.stderr)
        raise HTTPException(status_code=500,detail=f"Error al crear usuario: {str(e)} ")

def get_user_by_email(email:str,db:Session):
    user = db.query(User).filter(User.mail == email).first()
    return user

def get_user_by_email_verify(user_id : str,email:str,db:Session):
    user_db = db.query(User).filter(User.user_id == user_id).first()
    if user_db.mail != email: 
        validation = get_user_by_email(email,db)
        if validation is None:
            return True
        else:
            return False
    return True

def update_user_admin(user_id: str, user_update: UserUpdateAdmin, db: Session):
    db_user = get_user_by_id(user_id, db)
    if db_user:
        for attr, value in user_update.dict().items():
            if attr == "passhash" and value is not None:
                value = get_hashed_password(value)
            setattr(db_user, attr, value)
        db.commit()
        db.refresh(db_user)
        return db_user
    return None

def get_user_by_id(id:str,db:Session):
    user = db.query(User).filter(User.user_id == id).first()
    return user

def authenticate_user(username:str,password:str,db:Session):
    user = get_user_by_email(username,db)
    if not user:
        return False
    if not verify_password(password,user.passhash):
        return False
    
    return user