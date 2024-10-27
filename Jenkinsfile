pipeline {
   agent any
   
   stages {
      stage('Build') {
         steps {
            echo 'Building stage'
            bat 'mvn clean'
            bat 'mvn compile'
            bat 'mvn package'
            
         }
      }
      
      stage('Deploy') {
         steps {
            when {
               expression {
                  currentBuild.result == null || currentBuild.result == 'SUCCESS'
                  
                  echo 'Deploying stage'
                  bat  'java -jar ${currentBuild.name}.war --httpPort=8082'
               }
            }
         }
         
         
      }
      
   }
   
}