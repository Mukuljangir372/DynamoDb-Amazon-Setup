package com.mu.jan.relax.data

import android.content.Context
import android.util.Log
import androidx.constraintlayout.widget.ConstraintAttribute
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobileconnectors.dynamodbv2.document.Table
import com.amazonaws.mobileconnectors.dynamodbv2.document.datatype.Document
import com.amazonaws.mobileconnectors.dynamodbv2.document.datatype.DynamoDBEntry
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.model.*
import com.mu.jan.relax.utils.runOnBack

object DynamoDb {
    fun createTable(mContext: Context){
        runOnBack {
            val credentials = CognitoCachingCredentialsProvider(
                mContext,"us-east-2:5fd9d21b-3291-4aa9-81d5-b83173cb5216",Regions.US_EAST_2
            )

            val client = AmazonDynamoDBClient(credentials)

            client.setRegion(Region.getRegion(Regions.US_EAST_2))


//            val tableRequest = CreateTableRequest().withTableName("Demo")
//                .withKeySchema(mutableListOf<KeySchemaElement>(KeySchemaElement("id",KeyType.HASH)))
//                .withAttributeDefinitions(mutableListOf<AttributeDefinition>(AttributeDefinition("id",ScalarAttributeType.N)))
//                .withProvisionedThroughput(ProvisionedThroughput(1000,1000))
//
//            client.createTable(tableRequest)


            val table = Table.loadTable(client,"Demo")

            val doc = Document()
            doc.put("id","1")
            try{
                table.putItem(doc)
                Log.d("ABC","Success")
            }catch (e: Exception){
                Log.d("ABC","${e.localizedMessage}}")
            }



////            val value = AttributeValue("id")
////
////            val map = hashMapOf<String,AttributeValue>(
////                "name" to value
////            )
//            try{
////                client.putItem("Demo",map)
//                Log.d("ABC","Success")
//            }catch (e: Exception){
//                Log.d("ABC","${e.localizedMessage}}")
//            }

        }


    }

}