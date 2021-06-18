package util;

public class Message {

    public String nome;
    public float salario;
    public String cargo;

    public Message(String nome, float salario, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Message() {
        this.nome = "";
        this.salario = 0;
        this.cargo = "";
    }

    public String GetNome() {
        return this.nome;
    }

    public String GetCargo() {
        return this.cargo;
    }

    public float GetSalario() {
        return this.salario;
    }
}