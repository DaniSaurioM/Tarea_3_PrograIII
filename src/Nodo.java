public class Nodo {
    int n;
    private int t;
    int claves[];
    Nodo hijos[];
    boolean hoja;

    public Nodo(int t, boolean hoja) {
        this.n = 0;
        this.hoja = hoja;
        this.claves = new int[2*t - 1];
        this.hijos = new Nodo[2*t];
    }

    public void insertarNoLleno(int k) {
        int i = n-1;
        if (hoja == true) {
            while (i >= 0 && claves[i] > k) {
                claves[i+1] = claves[i];
                i--;
            }
            claves[i+1] = k;
            n++;
        } else {
            while (i >= 0 && claves[i] > k)
                i--;
            if (hijos[i+1].n == 2*t-1) {
                dividirHijo(i+1, hijos[i+1]);
                if (claves[i+1] < k)
                    i++;
            }
            hijos[i+1].insertarNoLleno(k);
        }
    }

    public void dividirHijo(int i, Nodo y) {
        Nodo z = new Nodo(y.t, y.hoja);
        z.n = t - 1;
        for (int j = 0; j < t-1; j++)
            z.claves[j] = y.claves[j+t];
        if (y.hoja == false) {
            for (int j = 0; j < t; j++)
                z.hijos[j] = y.hijos[j+t];
        }
        y.n = t - 1;
        for (int j = n; j >= i+1; j--)
            hijos[j+1] = hijos[j];
        hijos[i+1] = z;
        for (int j = n-1; j >= i; j--)
            claves[j+1] = claves[j];
        claves[i] = y.claves[t-1];
        n++;
    }

    public void eliminar(int k) {
        // Implementar eliminación
    }

    public Nodo buscar(int k) {
        int i = 0;
        while (i < n && k > claves[i])
            i++;
        if (claves[i] == k)
            return this;
        if (hoja == true)
            return null;
        return hijos[i].buscar(k);
    }

    public void imprimir() {
        for (int i = 0; i < n; i++) {
            if (hoja == false)
                hijos[i].imprimir();
            System.out.print(" " + claves[i]);
        }
        if (hoja == false)
            hijos[n].imprimir();
    }
}