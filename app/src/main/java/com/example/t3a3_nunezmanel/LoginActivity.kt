package com.example.t3a3_nunezmanel

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t3a3_nunezmanel.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val entrar = binding.enviarBtn

        entrar.setOnClickListener{
            val intent:Intent = Intent(this, MainActivity::class.java)
            val usuario = binding.usuarioTiet
            val password = binding.passwordTiet
            if(usuario.text.toString().length == 9){
                binding.usuarioTil.error = null
                if (password.text.toString().length > 1){
                    binding.passwordTil.error = null
                    intent.putExtra("Usuario",usuario.text.toString())
                    intent.putExtra("Password",password.text.toString())
                    startActivity(intent)
                }else{
                    binding.passwordTil.error = "Introduce una contraseña correcta"
                }
            }else{
                binding.usuarioTil.error = "Introduce un usuario correcto"
            }

        }

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}