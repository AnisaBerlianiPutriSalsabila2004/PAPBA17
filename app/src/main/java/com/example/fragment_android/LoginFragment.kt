package com.example.fragment_android

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentLogin = inflater.inflate(R.layout.fragment_login, container, false)
        val btnRegister = fragmentLogin.findViewById<Button>(R.id.loginButton)
        val name = MainActivity.name_obj
        val username = fragmentLogin.findViewById<EditText>(R.id.username_inp)
        val password = fragmentLogin.findViewById<EditText>(R.id.password_inp)

        btnRegister.setOnClickListener{
            if(username.text.toString()==MainActivity.username_obj && password.text.toString() == MainActivity.password_obj){
                val intentDashboard = Intent(activity, Dashboard::class.java)
                intentDashboard.putExtra("NAME_PASSING", name)
                startActivity(intentDashboard)
            }else{
                Toast.makeText(activity, "Username/Password salah", Toast.LENGTH_SHORT).show()
            }
        }
        // Inflate the layout for this fragment
        return fragmentLogin
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MateriFagment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}