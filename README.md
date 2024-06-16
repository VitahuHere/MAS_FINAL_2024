# Getting Started
# Cong Minh Vu s25206

## Launching the application
### Backend
Java spring boot with Maven, Java 17 and H2 database (auto created)
### Loading initial data
go to application.properties and set `spring.datasource.initialization-mode=always`. After first initialization, remove this like to prevent issues with constaints.
### Frontend
React with Typescript and Vite.
1. cd frontend
2. npm install
3. npm run dev
4. Open browser and go to http://localhost:5173/
5. Enjoy!
