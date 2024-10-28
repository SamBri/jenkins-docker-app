// Jenkinsfile (Declarative Pipeline)
pipeline {
   agent any
   
   parameters {
      string(name: 'BUILD_NAME', defaultValue: currentBuild.projectName, description: 'build name')
   }
   
   
   stages {
      stage('Build') {
         steps {
            echo 'Building stage'
            //   bat 'mvn clean' // no clean stage
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
            echo '${BUILD_NAME}'
            bat  'java -jar target/application-1.0.jar'
         }
      }
      
   }
   
}