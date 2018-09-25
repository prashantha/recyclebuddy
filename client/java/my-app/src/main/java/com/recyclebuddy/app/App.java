package com.recyclebuddy.app;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.cloud.automl.v1beta1.*;
import com.google.protobuf.ByteString;

/**
 * Recycle Buddy Test Client!
 * You can use this program to test your AutoML Vision Model using the Java client libraries for AutoML. 
 * Command Line Arguments: Pass in the path to the sample image file (that will be stored in args[0]).
 * Environment Variables: Set the environment variable GOOGLE_APPLICATION_CREDENTIALS to the fully qualified path 
 * to the JSON file containing the key for the Service Account that has permissions to predict using a model.
 * Change the constants below if you need to point this program to your own GCP project or Model.
 */
public class App 
{
    private static final String GCP_PROJECT = "recycle-buddy";
    private static final String GCP_LOCATION = "us-central1";
    private static final String AUTOML_MODEL_ID = "ICN5772469721644251948";
	public static void main( String[] args )
    {
    	PredictionServiceClient predictionServiceClient = null;
    	try {
    		   predictionServiceClient = PredictionServiceClient.create();
    		   ModelName name = ModelName.of(GCP_PROJECT, GCP_LOCATION, AUTOML_MODEL_ID);
    		   ByteString content = ByteString.copyFrom(Files.readAllBytes(Paths.get(args[0])));
    		   Image image = Image.newBuilder().setImageBytes(content).build();
    		   ExamplePayload examplePayload = ExamplePayload.newBuilder().setImage(image).build();

    		   Map<String, String> params = new HashMap<>();
    		   PredictResponse response = predictionServiceClient.predict(name, examplePayload, params);
    	       System.out.println(response.toString());
    		 }
    	catch (Throwable t) {
            System.out.println(t);
        }
    	finally {
    		if (predictionServiceClient != null) {
    			predictionServiceClient.close();
    		}    		
    	}
    }
}
