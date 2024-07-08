package com.david.easypark.uti

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel():ViewModel(){
    fun saveData(
        userData: UserData,
        context: Context
    ) =CoroutineScope(Dispatchers.IO).launch{
        val fireStoreRef = Firebase.firestore
            .collection("user")
            .document(userData.number)
        try {
            fireStoreRef.set(userData)
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully saved data",Toast.LENGTH_SHORT).show()

                }
        }
        catch (e:Exception){
            Toast.makeText(context, e.message,Toast.LENGTH_SHORT).show()
        }


    }
    fun retrieveData(
        number: String,
        context: Context,
        data: (UserData) -> Unit
    ) =CoroutineScope(Dispatchers.IO).launch{
        val fireStoreRef = Firebase.firestore
            .collection("user")
            .document(number)
        try {
            fireStoreRef.get()
                .addOnSuccessListener {
                    if (it.exists()) {
                        val userData = it.toObject<UserData>()!!
                        data(userData)
                    }else {Toast.makeText(context,"No User Data Found", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        catch(e:Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }

        }
    fun deleteData(
        number: String,
        context: Context,
        navController: NavController,
    ) =CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore
            .collection("user")
            .document(number)
        try {
            fireStoreRef.delete()
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully deleted data", Toast.LENGTH_SHORT).show()
                  navController.popBackStack()
                }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }

    }
    }

