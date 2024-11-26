package trabalho_final.Model;


public abstract class Conta implements ContaI {
    private static int numeroSequencial = 1;
    protected int numero;
    protected double saldo;
    protected Cliente dono;

    public Conta(Cliente dono) {
        this.numero = numeroSequencial++;
        this.dono = dono;
        this.saldo = 0;
    }

    @Override
    public boolean deposita(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean saca(double valor) {
        if (valor > 0) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public Cliente getDono() {
        return dono;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
}

