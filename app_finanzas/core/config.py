from dotenv import load_dotenv #Carga variables del archivo '.env'
import os #'os' Permite saltar entre carpetas del sistema operativo, se usa para buscar archivos

# Obtener la ruta al archivo .env
dotenv_path = os.path.join(os.path.dirname(__file__), '..', '.env')

# Cargar variables de entorno desde el archivo .env
load_dotenv(dotenv_path)

class Settings:
    PROJECT_NAME: str = "GASTOS_INGRESOS"
    PROJECT_VERSION: str = "0.0.1"
    PROJECT_DESCRIPTION: str = "Aplicación para administrar gastos personales"
    
    DB_HOST: str = os.getenv("DB_HOST")
    DB_USER: str = os.getenv("DB_USER")
    DB_PASSWORD: str = os.getenv("DB_PASSWORD")
    DB_NAME: str = os.getenv("DB_NAME")
    DB_PORT: str = os.getenv("DB_PORT", 3306) #default mysql
    
    DATABASE_URL = f"mysql+pymysql://{DB_USER}:{DB_PASSWORD}@{DB_HOST}:{DB_PORT}/{DB_NAME}"
    
    SECRET_KEY: str = os.getenv("SECRET_KEY")
    TOKEN_EXPIRE_MIN = 30 #in mins
    ALGORITHM: str = os.getenv("ALGORITHM")
    
settings = Settings()