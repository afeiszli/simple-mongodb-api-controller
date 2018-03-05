
#!groovy
import hudson.model.*


try {
    node {
 
        stage('checkout-and-test') {
            
            checkout scm
            def flag = true;
            
            def branch = BRANCH_NAME.toLowerCase();
            def source = BRANCH_NAME
            if (branch.contains('/')){
                branch = branch.substring(branch.lastIndexOf("/") + 1)
            }
            sh """oc process -f nodejs.json -p NAME=$branch -p SOURCE_REPOSITORY_URL=https://github.com/afeiszli/simple-mongodb-api-controller.git -p SOURCE_REPOSITORY_REF=$source -lapp=$branch | oc apply -f -"""
            sh """oc start-build $branch"""
            
        }
        
    }
} catch (err) {
    echo "in catch block"
    echo "Caught: ${err}"
    currentBuild.result = 'FAILURE'
    throw err
}
