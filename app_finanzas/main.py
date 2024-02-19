from fastapi import FastAPI, APIRouter
from appv1.routers import User
from core.config import settings

api_router = APIRouter()
api_router.include_router(User.router, prefix="/users", tags=["users"])

app = FastAPI(title=settings.PROJECT_NAME, version=settings.PROJECT_VERSION, description=settings.PROJECT_DESCRIPTION)
app.include_router(api_router)