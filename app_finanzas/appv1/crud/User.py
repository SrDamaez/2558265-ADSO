import sys
from appv1.models.User import User
from fastapi import HTTPException
from appv1.schemas.User import UserCreate, UserRead
from sqlalchemy.orm import Session
from core.security import get_hashed_password, verify_password
from core.utils import generate_user_id

def create_new_user(user: UserCreate, rol:str, db:Session):
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
        return db_user
    
    except Exception as e:
        db.rollback()
        #Imprimir el error en la consola
        print(f"Error alcrear ususario: {str(e)}", file=sys.stderr)
        
        #Devolver una respuesta de erorr detallada
        raise HTTPException(status_code=500, detail=f"Error al crear ususario: {str(e)}")
    
    
def  get_user_by_email(email: str, db: Session):
    user = db.query(User).filter(User.mail == email).first()
    return user

def get_user_by_id(id: str, db: Session):
    user = db.query(User).filter(User.user_id == id).first()
    return user

def authenticate_user(username: str, password: str, db: Session):
    user = get_user_by_email(username, db)
    if not user:
        return False
    if not verify_password(password, user.passhash):
        return False
    return user