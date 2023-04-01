public class ArbolB {
    Nodo raiz;
    int t;

    public ArbolB(int t) {
        this.raiz = null;
        this.t = t;
    }

    public void insertar(int k) {
        if (raiz == null) {
            raiz = new Nodo(t, true);
            raiz.claves[0] = k;
            raiz.n = 1;
        } else {
            if (raiz.n == 2 * t - 1) {
                Nodo s = new Nodo(t, false);
                s.hijos[0] = raiz;
                s.dividirHijo(0, raiz);
                int i = 0;
                if (s.claves[0] < k)
                    i++;
                s.hijos[i].insertarNoLleno(k);
                raiz = s;
            } else {
                raiz.insertarNoLleno(k);
            }
        }
    }

    public void eliminar(int k) {
        if (raiz == null)
            System.out.println("El árbol está vacío");
        else {
            raiz.eliminar(k);
            if (raiz.n == 0)
                if (raiz.hoja) {
                    raiz = null;
                }else {
                    raiz = raiz.hijos[0];
                }
        }
    }

    public Nodo buscar(int k) {
        return (raiz == null) ? null : raiz.buscar(k);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
}
