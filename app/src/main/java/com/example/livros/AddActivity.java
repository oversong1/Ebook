package com.example.livros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText title_input, author_input, pages_input;
    Button add_button, btn_voltar_consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        author_input = findViewById(R.id.author_input);
        pages_input = findViewById(R.id.pages_input);
        add_button = findViewById(R.id.add_button);
        btn_voltar_consulta = findViewById(R.id.btn_voltar_consulta);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        Integer.valueOf(pages_input.getText().toString().trim()));

                // Limpar os campos de entrada após adicionar o livro
                title_input.setText("");
                author_input.setText("");
                pages_input.setText("");

                // Indicar que a operação foi bem-sucedida e encerrar a atividade
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    public void fechar_tela(View v){
        this.finish();
    }
}