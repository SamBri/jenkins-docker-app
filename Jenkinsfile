// Jenkinsfile (Declarative Pipeline)
pipeline {
   agent any
   
   parameters {
      string(name: 'BUILD_NAME', defaultValue: currentBuild.name)
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
            echo 'App buildName ${BUILD_NAME}'
            //  bat  'java -jar target/${currentBuild.name}.war --httpPort=8082'
         }
      }
      
   }
   
}