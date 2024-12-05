
# Crop Monitoring System  

## Introduction  
This project is a **Crop Monitoring System** developed for Green Shadow (Pvt) Ltd., a mid-scale farm specializing in root crops and cereals. The system aims to manage the company’s fields, crops, staff, vehicles, and equipment while supporting monitoring logs and data analysis.  

## Features  
- **User Roles**:  
  - MANAGER: Full access to all CRUD operations.  
  - ADMINISTRATIVE: Restricted from modifying crop-related details.  
  - SCIENTIST: Restricted from modifying staff, vehicle, or equipment data.  

- **Services**:  
  - **Field Service**: Manages fields allocated for cultivation.  
  - **Crop Service**: Handles crop types and growth stages.  
  - **Staff Service**: Manages staff assignments and resources.  
  - **Vehicle Service**: Oversees vehicle management and allocations.  
  - **Equipment Service**: Tracks and manages agricultural equipment.  
  - **Log Monitoring Service**: Records and tracks crop-related observations.  
  - **Authentication Service**: Handles secure user authentication using Spring Security and OAuth 2.0.  

- **Analysis**:  
  - Relational analysis of resources like labor and vehicle assignments.  
  - Spatial and temporal analysis for enhanced decision-making.  

## Technologies Used  
- **Frontend**:  
  - HTML, CSS, CSS Frameworks, JavaScript, jQuery, AJAX  

- **Backend**:  
  - Spring Boot  
  - Spring Data, Spring Web MVC, Spring Validation, Spring Security  
  - Lombok, Model Mapper, Jackson  
  - JWT Authentication  
  - MySQL  

## System Design  
- **Three-Layer Architecture**:  
  1. **API Layer**: Handles HTTP requests and responses.  
  2. **Service Layer**: Implements business logic.  
  3. **Persistence Layer**: Manages data storage using JPA with MySQL.  

- **Key Entities**:  
  - **Field**: Includes GPS location, extent size, and allocated crops.  
  - **Crop**: Tracks crop type, growth stage, and field allocation.  
  - **Staff**: Manages staff information and assignments.  
  - **Vehicle**: Oversees vehicle details and usage.  
  - **Equipment**: Tracks agricultural tools and machinery.  

## Installation and Setup  
1. Clone the repository:  
   ```bash  
   git clone https://github.com/Likshan-Lahiru/Proposed-crop-monitoring-system-BackEnd.git 
   cd file Name  
   ```  

2. Set up the MySQL database:  
   - Create a new database for the system.  
   - Configure `application.properties` with your database credentials.  

3. Run the application:  
   ```bash  
   mvn spring-boot:run  
   ```  

4. Access the system via `http://localhost:8080`.  

## Security Features  
- **Password Encryption**: Ensures secure storage of user credentials.  
- **Role-Based Access Control**: Defines permissions for different user roles.  
- **OAuth 2.0 Integration**: Enhances authentication and authorization mechanisms.  

## Contribution  
Feel free to contribute to this project. Fork the repository and submit a pull request for review.  

## License  
This project is licensed under the MIT License.  

---

If you need further customizations or additional sections, let me know!
