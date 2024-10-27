pipeline {
   agent any
   
   stages {
      stage('Build') {
         steps {
            echo 'Building stage'
            sh 'mvn clean'
            sh 'mvn compile'
            sh 'mvn package'
            
         }
      }
    stage('Deploy') {
         steps {
            echo 'Deploying stage'
         }
      }
     
   }
}