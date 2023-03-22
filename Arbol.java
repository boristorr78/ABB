
public class Arbol {
 private Nodo raiz;
 
 public Arbol() {
    raiz = null;
}

public Nodo getRaiz() {
    return raiz;
}

public void insertar(int valor) {
    Nodo nodo = new Nodo(valor);
    if (raiz == null) {
        raiz = nodo;
    } else {
        insertarNodo(raiz, nodo);
    }
}

private void insertarNodo(Nodo actual, Nodo nuevo) {
    if (nuevo.getValor() < actual.getValor()) {
        if (actual.getIzquierdo() == null) {
            actual.setIzquierdo(nuevo);
        } else {
            insertarNodo(actual.getIzquierdo(), nuevo);
        }
    } else if (nuevo.getValor() > actual.getValor()) {
        if (actual.getDerecho() == null) {
            actual.setDerecho(nuevo);
        } else {
            insertarNodo(actual.getDerecho(), nuevo);
        }
    } else {
        System.out.println("El valor ya existe");
    }
}

public void buscar(int valor) {
    if (buscarNodo(raiz, valor)) {
        System.out.println("Valor " + valor + " encontrado.");
    } else {
        System.out.println("Valor " + valor + " no encontrado.");
    }
}

private boolean buscarNodo(Nodo actual, int valor) {
    if (actual == null) {
        return false;
    }
    if (actual.getValor() == valor) {
        return true;
    }
    if (valor < actual.getValor()) {
        return buscarNodo(actual.getIzquierdo(), valor);
    } else {
        return buscarNodo(actual.getDerecho(), valor);
    }
}

public void eliminar(int valor) {
    raiz = eliminarNodo(raiz, valor);
}

private Nodo eliminarNodo(Nodo actual, int valor) {
    if (actual == null) {
        return null;
    }
    if (valor == actual.getValor()) {
        if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
            return null;
        }
        if (actual.getIzquierdo() == null) {
            return actual.getDerecho();
        }
        if (actual.getDerecho() == null) {
            return actual.getIzquierdo();
        }
        int valorMinimo = valorMinimo(actual.getDerecho());
        actual.setValor(valorMinimo);
        actual.setDerecho(eliminarNodo(actual.getDerecho(), valorMinimo));
        return actual;
    }
    if (valor < actual.getValor()) {
        actual.setIzquierdo(eliminarNodo(actual.getIzquierdo(), valor));
    } else {
        actual.setDerecho(eliminarNodo(actual.getDerecho(), valor));
    }
    return actual;
}

private int valorMinimo(Nodo nodo) {
    if (nodo.getIzquierdo() == null) {
        return nodo.getValor();
    } else {
        return valorMinimo(nodo.getIzquierdo());
    }
}

public void listar() {
    listarNodos(raiz);
}

private void listarNodos(Nodo nodo) {
    if (nodo != null) {
        listarNodos(nodo.getDerecho());
        System.out.println(nodo.getValor());
        listarNodos(nodo);

}
}
}
