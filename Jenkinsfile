// Jenkinsfile (Declarative Pipeline)
pipeline {
   agent any
   
   
   stages {
      stage('Build') {
         steps {
            echo 'Building stage'
            bat 'mvn compile'
            bat 'mvn package'
            
         }
      }
      
      stage('Deploy') {
         when {
            expression {
               currentBuild.result == null || currentBuild.result == 'SUCCESS'
            }
         }
         
         steps {
            echo 'Deploying stage'
          /* echo '${params.BUILD_NAME}'
            bat  'java -jar target/application-1.0.jar' */
         }
      }
      
   }
   
}