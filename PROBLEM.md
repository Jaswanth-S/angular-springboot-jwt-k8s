## Problem Statement: Experiment with deploying Angular SPA that communicate with Spring Boot application on K8s Cluster in AWS EKS  

* This is to deploy Angular SPA that communicate with Spring Boot application on K8s Cluster in AWS EKS. 
  SpringBoot uses mysql for persistence of data. 
      

This exercise contains following folders 
    
    - AngularFrontend  - This is an Angular SPA 
    - k8s              - contains manifest files, these files are explained below
    - SbService        - This is a Spring Boot application
    
This exercise contains following files in k8s folder
    
    - angular.yml     - This is to create the deployment, service of type LoadBalancer for Angular SPA
    - configmap.yml   - This is to create ConfigMap
    - secret.yml      - This is to create secret
    - mysql.yml       - This is to create PersistentVolume, PersistentVolumeClaim and the deployment, service of type ClusterIP for mysql
    - springboot.yml  - This is to create the deployment, service of type LoadBalancer for Spring Boot application

**Note**: You need to go through the comments thoroughly and complete the exercise.
      
Understand and do the following steps to complete this exercise:
    
    1. Modify the properties in `application.yml` of `SbService`. Push SbService image to Docker Hub.
    2. Verify that EKS cluster is created using eksctl and is ready. 
    3. Implement configmap.yml to define a ConfigMap.
    4. Implement secret.yml file to define a secret.
    5. Implement mysql.yml file to define PersistentVolume, PersistentVolumeClaim and the deployment, service of type ClusterIp for mysql.
    6. Implement springboot.yml file to define the deployment, service of type LoadBalancer for Spring Boot application.
    7. Test in Postman the functionalities to create,read and update user. 
    8. Open browser and check for `<external-ip-of-SbService>:<port>/api/v1/` url, you can view the list of users.
    9. Now go to AnularFrontend, make changes in environments/environment.ts file, change API as follows `<external-ip-of-SbService>:<port>/api/v1/`.  
    10.Now build AngularFrontend, use command `ng build`, push AngularFrontend image to Docker Hub 
    11.Implement angular.yml file to define the deployment, service of type LoadBalancer for Angular SPA. 
    12.Test the Angular SPA, open browser and check for `<external-ip-of-angular-service>:<port>` url.          
                  
### Instructions
 - Take care of whitespace/trailing whitespace
 - Do not change the provided code unless instructed
 - Ensure your code compiles without any errors/warning/deprecations 
 - Follow best practices while coding
