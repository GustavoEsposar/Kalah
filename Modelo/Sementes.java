package Modelo;
public class Sementes {
private int quantidadeDeSementes;

public Sementes(int quantidadeDeSementes) {
    this.quantidadeDeSementes = quantidadeDeSementes;
}

public int getquantidadeDeSementes() {
    return quantidadeDeSementes;
}

public void setquantidadeDeSementes(int quantidadeDeSementes) {
this.quantidadeDeSementes = quantidadeDeSementes;
}

public void adicionarSementes(int quantidadeDeSementesDeSementes){
    if(this.quantidadeDeSementes < 47){
        this.quantidadeDeSementes += quantidadeDeSementesDeSementes;
    }else{
        throw new IllegalStateException("Uma casa não pode ter mais que 47 sementes");
    }

}
public void removerSementes(int quantidadeDeSementes){
    if (quantidadeDeSementes <= this.quantidadeDeSementes) {
        this.quantidadeDeSementes -= quantidadeDeSementes;
    } else {
        throw new IllegalArgumentException("Não há sementes suficientes");
    }
}

public String toString() {
    return "Sementes: " + quantidadeDeSementes;
}
}
