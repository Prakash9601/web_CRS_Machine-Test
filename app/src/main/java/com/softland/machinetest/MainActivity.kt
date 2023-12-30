package com.softland.machinetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.softland.machinetest.navigation.SetupNavGraph
import com.softland.machinetest.ui.theme.MachineTestTheme
import com.softland.machinetest.utils.ConnectionState
import com.softland.machinetest.utils.Const
import com.softland.machinetest.utils.connectivityState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContent {
            MachineTestTheme {
                // A surface container using the 'background' color from the theme
                val state by connectivityState()
                val mcontext = LocalContext.current
                if(state == ConnectionState.Unavailable){
                    Const.showToast(mcontext,mcontext.getString(R.string.please_check_your_internet_connection))
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavGraph()
                }
            }
        }
    }
}

