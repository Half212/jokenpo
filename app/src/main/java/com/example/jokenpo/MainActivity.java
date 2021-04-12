package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoUser){
        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3); // 0 1 2
        String[] opcoesUser = {"Pedra", "Papel", "Tesoura"}; //array
        String opcaoApp = opcoesUser[numero];//array
        switch (opcaoApp){

            case "Pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(//App ganhador
                (opcaoApp == "Pedra" && opcaoUser == "Tesoura") ||
                (opcaoApp == "Papel" && opcaoUser == "Pedra") ||
                (opcaoApp == "Tesoura" && opcaoUser == "Papel")
        ) {
            textoResultado.setText("Você Perdeu :( ");

        }else if(//User ganhador
                (opcaoUser == "Pedra" && opcaoApp == "Tesoura") ||
                (opcaoUser == "Papel" && opcaoApp == "Pedra") ||
                (opcaoUser == "Tesoura" && opcaoApp == "Papel")
        ){
            textoResultado.setText("Você Ganhou :) ");

        }else{//empate
            textoResultado.setText("Empatou ._. ");
        }

            System.out.println("item clicado: " + opcaoApp);




    }

}