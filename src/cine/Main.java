package cine;

import java.util.Random;
import javax.swing.JOptionPane;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Persona> entradas = new ArrayList();
        Random rnd = new Random();
        int opcion = 0;
        double totalRecaudado = 0,
                promedioRecaudo = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué desea hacer?"
                    + "\n1. Registrar una persona en el ArrayList."
                    + "\n2. Mostrar todos los datos del Arraylist ordenado."
                    + "\n3. Totales por categoria."
                    + "\n4. Elimiar personas de una categoria."
                    + "\n5. Salir"));
            switch (opcion) {
                case 1:
                    Persona p = new Persona();
                    int e = (rnd.nextInt(55) + 5 );
                    p.setEdad(e);
                    if (e >= 5 && e <= 10) {
                        p.setValorBoleta(3000);
                    } else if (e >= 11 && e <= 17) {
                        p.setValorBoleta(7000);
                    } else {
                        p.setValorBoleta(9000);
                    }
                    entradas.add(p);
                    JOptionPane.showMessageDialog(null, "Persona registrada con éxito");
                    break;
                case 2:
                    if (!entradas.isEmpty()) {
                        Persona aux = new Persona();
                        int o = Integer.parseInt(JOptionPane.showInputDialog("Desea ordena el Array por:"
                                + "\n1. Edades"
                                + "\n2. Valores de las boletas"));
                        if (o == 1) {
                            for (int i = 0; i < entradas.size(); i++) {
                                for (int j = 0; j < entradas.size(); j++) {
                                    if (entradas.get(i).getEdad() < entradas.get(j).getEdad()) {
                                        aux = entradas.get(i);
                                        entradas.set(i, entradas.get(j));
                                        entradas.set(j, aux);
                                    }
                                }
                            }
                            String mensaje = "";
                            for (int j = 0; j < entradas.size(); j++) {
                                String categoria = "";
                                if (entradas.get(j).getValorBoleta() == 3000) {
                                    categoria = "Niños";
                                } else if (entradas.get(j).getValorBoleta() == 7000) {
                                    categoria = "Adolescentes";
                                } else {
                                    categoria = "Adultos";
                                }
                                mensaje += "Edad de la persona: " + entradas.get(j).getEdad()
                                        + "\u2000 Precio de la boleta: " + entradas.get(j).getValorBoleta()
                                        + "\u2000 Categoría: " + categoria + "\n";
                            }
                            JOptionPane.showMessageDialog(null,
                                    "-------------------------------------------ENTRADAS-------------------------------------"
                                    + "\n\n" + mensaje);
                        } else if (o == 2) {
                            for (int i = 0; i < entradas.size(); i++) {
                                for (int j = 0; j < entradas.size(); j++) {
                                    if (entradas.get(i).getValorBoleta() < entradas.get(j).getValorBoleta()) {
                                        aux = entradas.get(i);
                                        entradas.set(i, entradas.get(j));
                                        entradas.set(j, aux);
                                    }
                                }
                            }
                            String mensaje = "";
                            for (int j = 0; j < entradas.size(); j++) {
                                String categoria = "";
                                if (entradas.get(j).getValorBoleta() == 3000) {
                                    categoria = "Niños";
                                } else if (entradas.get(j).getValorBoleta() == 7000) {
                                    categoria = "Adolescentes";
                                } else {
                                    categoria = "Adultos";
                                }
                                mensaje += "Edad de la persona: " + entradas.get(j).getEdad()
                                        + "\u2000 Precio de la boleta: " + entradas.get(j).getValorBoleta()
                                        + "\u2000 Categoría: " + categoria + "\n";
                            }
                            JOptionPane.showMessageDialog(null,
                                    "-------------------------------------------ENTRADAS-------------------------------------"
                                    + "\n\n" + mensaje);
                        } else if (o > 2) {
                            JOptionPane.showMessageDialog(null, "ERROR!! Esa opción no es valida");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR!! El ArrayList está vacío, registra una persona");
                    }
                    break;
                case 3:
                    if (!entradas.isEmpty()) {
                        int c = Integer.parseInt(JOptionPane.showInputDialog("Elige una categoria: "
                                + "\n1. Niños"
                                + "\n2. Adolescentes"
                                + "\n3. Adultos"));
                        if (c >= 1 && c <= 3) {
                            switch (c) {
                                case 1:
                                    int cont = 0;
                                    for (int i = 0; i < entradas.size(); i++) {
                                        if (entradas.get(i).getValorBoleta() == 3000) {
                                            cont++;
                                            totalRecaudado += entradas.get(i).getValorBoleta();
                                        }
                                    }
                                    promedioRecaudo = (float) (totalRecaudado / cont);
                                    if (cont > 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "------------------------------------------ENTRADAS INFORMACION-------------------------------------" + "\n"
                                                + "La cantidad de entradas de esta categoria es: " + cont + "\n"
                                                + "El total recaudado es: " + totalRecaudado + "\n"
                                                + "El promedio recaduo es: " + promedioRecaudo);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ERROR, no hay personas en esta categoria");
                                    }
                                    break;
                                case 2:
                                    int cont2 = 0;
                                    for (int i = 0; i < entradas.size(); i++) {
                                        if (entradas.get(i).getValorBoleta() == 7000) {
                                            cont2++;
                                            totalRecaudado += entradas.get(i).getValorBoleta();
                                        }
                                    }
                                    promedioRecaudo = (float) (totalRecaudado / cont2);
                                    if (cont2 > 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "------------------------------------------ENTRADAS INFORMACION-------------------------------------" + "\n"
                                                + "La cantidad de entradas de esta categoria es: " + cont2 + "\n"
                                                + "El total recaudado es: " + totalRecaudado + "\n"
                                                + "El promedio recaduo es: " + promedioRecaudo);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ERROR, no hay personas en esta categoria");
                                    }

                                    break;
                                case 3:
                                    int cont3 = 0;
                                    for (int i = 0; i < entradas.size(); i++) {
                                        if (entradas.get(i).getValorBoleta() == 9000) {
                                            cont3++;
                                            totalRecaudado += entradas.get(i).getValorBoleta();
                                        }
                                    }
                                    promedioRecaudo = (float) (totalRecaudado / cont3);
                                    if (cont3 > 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "------------------------------------------ENTRADAS INFORMACION-------------------------------------" + "\n"
                                                + "La cantidad de entradas de esta categoria es: " + cont3 + "\n"
                                                + "El total recaudado es: " + totalRecaudado + "\n"
                                                + "El promedio recaduo es: " + promedioRecaudo);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ERROR, no hay personas en esta categoria");
                                    }

                                    break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR!! Esa opción no es valida");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR!! El ArrayList está vacío, registra una persona");
                    }
                    break;
                case 4:
                    if (!entradas.isEmpty()) {
                        int categoria = Integer.parseInt(JOptionPane.showInputDialog("Elige una categoria: "
                                + "\n1. Niños"
                                + "\n2. Adolescentes"
                                + "\n3. Adultos"));
                        if (categoria >= 1 && categoria <= 3) {
                            switch (categoria) {
                                case 1:
                                    int cont = 0,
                                     valor = 0;
                                    while (valor < entradas.size()) {
                                        for (int j = 0; j < entradas.size(); j++) {
                                            if (entradas.get(j).getValorBoleta() == 3000) {
                                                entradas.remove(j);
                                                cont++;
                                            }
                                        }
                                        valor++;
                                    }
                                    if (cont > 0) {
                                        JOptionPane.showMessageDialog(null, "Objetos eliminados del Array");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ERROR, no hay personas en esta categoria");
                                    }
                                    break;
                                case 2:
                                    int cont2 = 0,
                                     valor2 = 0;
                                    while (valor2 < entradas.size()) {
                                        for (int j = 0; j < entradas.size(); j++) {
                                            if (entradas.get(j).getValorBoleta() == 7000) {
                                                entradas.remove(j);
                                                cont2++;
                                            }
                                        }
                                        valor2++;
                                    }
                                    if (cont2 > 0) {
                                        JOptionPane.showMessageDialog(null, "Objetos eliminados del Array");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ERROR, no hay personas en esta categoria");
                                    }
                                    break;
                                case 3:
                                    int cont3 = 0,
                                     valor3 = 0;
                                    while (valor3 < entradas.size()) {
                                        for (int j = 0; j < entradas.size(); j++) {
                                            if (entradas.get(j).getValorBoleta() == 9000) {
                                                entradas.remove(j);
                                                cont3++;
                                            }
                                        }
                                        valor3++;
                                    }
                                    if (cont3 > 0) {
                                        JOptionPane.showMessageDialog(null, "Objetos eliminados del Array");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ERROR, no hay personas en esta categoria");
                                    }

                                    break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR!! Esa opción no es valida");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR!! El ArrayList está vacío, registra una persona");
                    }
                    break;
            }
        } while (opcion <= 4);
    }

}
