// Jenkinsfile (Declarative Pipeline)
pipeline {
   agent any
   
       environment {
        // The MY_KUBECONFIG environment variable will be assigned
        // the value of a temporary file.  For example:
        //   /home/user/.jenkins/workspace/cred_test@tmp/secretFiles/546a5cf3-9b56-4165-a0fd-19e2afe6b31f/kubeconfig.txt
        BUILD_NAME = currentBuild.name
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
            echo 'App buildName  ${BUILD_NAME}'
            //  bat  'java -jar target/${currentBuild.name}.war --httpPort=8082'
         }
      }
      
   }
   
}