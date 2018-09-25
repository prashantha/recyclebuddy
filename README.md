# recyclebuddy
This is a test program to post images of trash to a Machine Learning model hosted in Google Cloud Platform (GCP) for predicting if an image has organic material (and hence is compostable) or if it has some plastic contamination. The model in GCP uses Cloud AutoML.
You can use this program to test your AutoML Vision Model using the Java client libraries for AutoML.
 * Please install Java 1.8, set JAVA_HOME system environment variable and update the PATH to include JAVA_HOME/bin.
 * Please install Maven. 
 * Build the project by executing 'mvn clean package'.
 * Run the program by executing 'java -cp target/my-app-1.0-SNAPSHOT.jar com.recyclebuddy.app.App "C:\dev\recyclebuddy\resources\testImage.jpg".  
 * Command Line Arguments: The fully qualified path to the test image file is the first command line parameter (that will be stored in args[0] of the main() function).
 * Make sure you have downloaded or been issued a JSON file containing a key to the Service Account in GCP that has permissions to run the prediction on a model.
 * Set the environment variable GOOGLE_APPLICATION_CREDENTIALS to the fully qualified path of the JSON file containing the key to the Service Account.
 * Change the constants GCP_PROJECT and AUTOML_MODEL_ID if you need to point this program to your own GCP project or Model.
 * Eclipse: Make sure you Import this project as a Maven project.
 * Eclipse: Set command line parameters (such as the path to the test image file) and environment variables (such as GOOGLE_APPLICATION_CREDENTIALS) by right clicking on the project, choosing Properties and then selecting Run/Debug Properties.
