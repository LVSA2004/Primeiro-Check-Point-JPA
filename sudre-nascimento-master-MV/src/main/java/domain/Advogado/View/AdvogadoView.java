package domain.Advogado.View;

import domain.Advogado.Model.Advogado;

import javax.swing.*;

public class AdvogadoView {
    public static Advogado formAbertura(){
        String nome = JOptionPane.showInputDialog("Nome do Advogado: ");
        String numeroOAB = JOptionPane.showInputDialog("Número da OAB: ");

        Advogado advogado = new Advogado();

        advogado.setNome(nome);
        advogado.setNumeroOAB(numeroOAB);

        return advogado;
    }
}
