/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasdobles;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhon
 */
public class miLista {
    
    nodo cab;
    int cont7, cont8, cont9;
    int cont10;
    public miLista(){
        cab = null;
    }
    
    public nodo BuscarRegi(String regis){
        if(cab==null)
            return null;
        else{
            nodo p = cab;
            while(p!=null){
                if((p.civil).equals(regis))
                    return p;
                else
                    p=p.sig; //Avanza un posición en la lista
            }
            return null;
        }
    }
    
    public nodo BuscarID(int ID){
        if(cab==null)
            return null;
        else{
            nodo p = cab;
            while(p!=null){
                if(p.id == ID)
                    return p;
                else
                    p=p.sig; //Avanza un posición en la lista
            }
            return null;
        }
    }
    
    public boolean ListaVacia(){
        return cab==null?true:false;
    }
    
    public nodo CrearNodo(JTextField JtCivil,
                          JTextField JtNombre,
                          JTextField JtTalla,
                          JTextField JtPeso,
                          JTextField JtEdad,
                          JTextField JtMuni,
                          JTextField JtNom,
                          JTextField JtId){
        
        nodo buscar1 = null;
        nodo buscar2 = null;
        nodo bus =  null;
        
        try{
            buscar1 = BuscarRegi(JtCivil.getText());
            if(buscar1 != null){
                JOptionPane.showMessageDialog(null, "Error: El núm. del registro civil ya se encuentra "
                                                  + "registrado. Intente nuevamente!"); 
                JtCivil.setText("");
                JtCivil.requestFocus();
                return null;
            } 
            
            buscar2 = BuscarID(Integer.parseInt(JtId.getText()));
            if(buscar2 != null){
                JOptionPane.showMessageDialog(null, "Error: La ID ya se encuentra "
                                                  + "registrado. Intente nuevamente!");
                JtId.setText("");
                JtId.requestFocus();
                return null;
            }     
            
            
            if(JtMuni.getText().equals("Lorica")){
                cont7++;
            }
            if(JtMuni.getText().equals("Montería")){
                cont8++;
            }
            if(JtMuni.getText().equals("Sahagún")){
                cont9++;
            }

            nodo info = new nodo(JtCivil.getText(),
                                 JtNombre.getText(),
                                 Float.parseFloat(JtTalla.getText()),
                                 Integer.parseInt(JtPeso.getText()),
                                 Integer.parseInt(JtEdad.getText()),
                                 JtMuni.getText(),
                                 JtNom.getText(),
                                 Integer.parseInt(JtId.getText())
                                 );
            return info;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
            return null;
        }        
    }
    
     public nodo UltimoNodo(){
        if(cab == null)
            return null;
        else{
            nodo p = cab;
            while (p.sig != null) {
                p = p.sig;
            }
            return p;
        }
    }
    
    public void AddFinal(JTextField JtCivil,
                         JTextField JtNombre,
                         JTextField JtTalla,
                         JTextField JtPeso,
                         JTextField JtEdad,
                         JTextField JtMuni,
                         JTextField JtNom,
                         JTextField JtId){
        
        nodo info = CrearNodo(JtCivil,
                             JtNombre,
                             JtTalla,
                             JtPeso,
                             JtEdad,
                             JtMuni,
                             JtNom,
                             JtId);
        if(info != null){
            if(cab == null){
                cab = info;
                JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo elemento "
                                                  + "a la lista.  La lista estaba vacía!!!");
            }
            else{
                nodo ultimo = UltimoNodo();
                ultimo.sig = info;
                ultimo.ant = ultimo;
                JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo elemento al "
                                                  + "final de la lista.");
            }
        }
        else{
        }
    }
    
    public void AddEntreNodos(JTextField JtCivil,
                              JTextField JtNombre,
                              JTextField JtTalla,
                              JTextField JtPeso,
                              JTextField JtEdad,
                              JTextField JtMuni,
                              JTextField JtNom,
                              JTextField JtId){
        if(ListaVacia()){
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacía!!!");
        }
        else{
            String regis = JOptionPane.showInputDialog("Ingrese el núm. del registro civil de referencia "
                                                     + " en donde va agregar entre nodos.");
            nodo buscar = BuscarRegi(regis);
            if(buscar == null){
                JOptionPane.showMessageDialog(null, "El núm. del registro civil no está registrado!!!");
            }
            else{
               nodo info = null;
               do{
                   info = CrearNodo(JtCivil,
                                    JtNombre,
                                    JtTalla,
                                    JtPeso,
                                    JtEdad,
                                    JtMuni,
                                    JtNom,
                                    JtId);
                   if(info == null){
                         JOptionPane.showMessageDialog(null, "Error al crear nodo! Intente nuevamente.");
                     }
               }while(info == null);
               info.sig = buscar.sig;
               buscar.sig = info;
               info.ant = buscar;
               buscar = buscar.ant;
               JOptionPane.showMessageDialog(null, "Nodo registrado entre nodos.");
            }
        }
    }
    
    public void AddInicio(JTextField JtCivil,
                          JTextField JtNombre,
                          JTextField JtTalla,
                          JTextField JtPeso,
                          JTextField JtEdad,
                          JTextField JtMuni,
                          JTextField JtNom,
                          JTextField JtId){
        
        nodo info = CrearNodo(JtCivil,
                              JtNombre,
                              JtTalla,
                              JtPeso,
                              JtEdad,
                              JtMuni,
                              JtNom,
                              JtId);
        if(info != null){
            if(cab == null){
                cab = info;
                JOptionPane.showMessageDialog(null,"Se ha registrado un nuevo elemento "
                                                 + "a la lista.  La lista estaba vacía.");
            }
            else{
                info.sig = cab;
                cab.ant = info;
                cab = info;
                JOptionPane.showMessageDialog(null,"Se ha registrado un nuevo elemento al "
                                                 + "inicio de la lista.");
            }
        }
        else{
        }
    }
    
    public void RegistrarFilaJTable(DefaultTableModel miModelo,
        int Fila, nodo info){
        miModelo.setValueAt(info.civil, Fila, 0);
        miModelo.setValueAt(info.nombre, Fila, 1);
        miModelo.setValueAt(info.talla, Fila, 2);
        miModelo.setValueAt(info.peso, Fila, 3);
        miModelo.setValueAt(info.edad, Fila, 4);
        miModelo.setValueAt(info.munici, Fila, 5);
        miModelo.setValueAt(info.nom, Fila, 6);
        miModelo.setValueAt(info.id, Fila, 7);
    }
    
    public void LlenarJTable(JTable tab){
        nodo p = cab;
        int i = 0;
        DefaultTableModel miModelo=new DefaultTableModel();
        miModelo.addColumn("Registro civil");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Talla");
        miModelo.addColumn("Peso");
        miModelo.addColumn("Edad");
        miModelo.addColumn("Municipio");
        miModelo.addColumn("Nom. Represen");
        miModelo.addColumn("ID");
        while(p != null){
            miModelo.addRow(new Object[]{"", "", "", "", "", "", ""});
            RegistrarFilaJTable(miModelo,i,p);
            p = p.sig;
            i++;
        }
        tab.setModel(miModelo);
    }
    
    public void Busqueda1(){
       String info = JOptionPane.showInputDialog("Ingrese el número del registro civil para consultar la información");
       nodo buscar = BuscarRegi(info);
       if(ListaVacia()){
           JOptionPane.showMessageDialog(null,"La lista está vacia!!!");
       }
       else{
           if(buscar == null){
               JOptionPane.showMessageDialog(null,"Error: El núm. del registro civil que ingresó no está registrado");
           }
           else{
               JOptionPane.showMessageDialog(null,"Registro civil encontrado con éxito!!!");
               buscar.Info();
           }
       }
    }
    
    public void Busqueda2(){
         String info = JOptionPane.showInputDialog("Ingrese la ID del representante para consultar la información.");
         nodo buscar = BuscarID(Integer.parseInt(info));
         if(ListaVacia()){
           JOptionPane.showMessageDialog(null,"La lista está vacia!!!");
         }
       else{
           if(buscar == null){
               JOptionPane.showMessageDialog(null,"Error: La ID que ingresó no está registrada");
           }
           else{
               JOptionPane.showMessageDialog(null,"ID encontrada con éxito!!!");
               buscar.Info();
           }
       }
    }
    
    public void BusquedaTP(){
        int op;
        do{
          op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su opción: \n"
                                                        + "1. Buscar información de talla y peso por núm. de registro civil. \n"
                                                        + "2. Buscar información de talla y peso por ID del representante. \n"
                                                        + "3. Salir. \n"
                                                        + "Ingrese su opción.(?)"));
          switch(op){
              case 1:
                  Busqueda1();
              break;
              case 2:
                  Busqueda2();
              break;
              case 3:
                  JOptionPane.showMessageDialog(null,"Adios!!!");
              break;
              default:JOptionPane.showMessageDialog(null,"Opción invalida!");
          }
        }while(op != 3);
    }
   
    public void DeleteInfor(String regis){
        if(ListaVacia()){
            JOptionPane.showMessageDialog(null, "La lista está vacia");
        }
        else{
            nodo p, q;
            p = BuscarRegi(regis);
            if(p == null){
                JOptionPane.showMessageDialog(null, "El núm. del registro civil buscado para eliminar "
                                                  + " NO se encuentra registrado!");
            }
            else
                if(p == cab && cab.sig == null){
                    cab = null;
                    JOptionPane.showMessageDialog(null, "Elemento eliminado, la lista esta vacía!");
                }
            else
                    if(p == cab && cab.sig != null){
                        cab=cab.sig;
                        cab.ant=null;
                        p.sig=null;
                        p=null;
                       JOptionPane.showMessageDialog(null,"Elemento eliminado, en el inicio de la lista!");
                    }
            else
                        if(p.sig == null){
                            q = cab;
                            while(q.sig!=p){
                                q = q.sig;
                                q.sig = null;
                                p.ant = null;
                                p = null;
                                JOptionPane.showMessageDialog(null,"Elemento eliminado, al final de la lista!");
                            }
                        }
            else{
                         p.ant.sig=p.sig;
                         p.sig.ant=p.ant;
                         p.sig=p.ant=null;
                         p=null;
                         JOptionPane.showMessageDialog(null,"Elemento eliminado!");           
                }
           }
    }
    
    public int BajosTalla1(){
        int con = 0;
        nodo info;
        if(ListaVacia()){
           JOptionPane.showMessageDialog(null, "La lista está vacia!!!"); 
        }
        else{
            info = cab;
            do{
               if((info.edad > 3 && info.edad <7) && (info.talla < 1.00) && (info.munici).equals("Lorica")){
                   con++;
               }
              info = info.sig;
            }while(info != null);
        }
        return con;
    }
    
    public int BajosTalla2(){
        int con = 0;
        nodo info;
        if(ListaVacia()){
           JOptionPane.showMessageDialog(null, "La lista está vacia!!!"); 
        }
        else{
            info = cab;
            do{
               if((info.edad > 3 && info.edad <7) && (info.talla < 1.00) && (info.munici).equals("Montería")){
                   con++;
               }
              info = info.sig;
            }while(info != null);
        }
        return con;
    }
    
    public int BajosTalla3(){
        int con = 0;
        nodo info;
        if(ListaVacia()){
           JOptionPane.showMessageDialog(null, "La lista está vacia!!!"); 
        }
        else{
            info = cab;
            do{
               if((info.edad > 3 && info.edad <7) && (info.talla < 1.00) && (info.munici).equals("Sahagún")){
                   con++;
               }
              info = info.sig;
            }while(info != null);
        }
        return con;
    }
    
    public void MostarTallas(){
         JOptionPane.showMessageDialog(null, "Reporte de los niños con problemas de estatura en cada municipio. \n"
                                          + "Lorica, cantidad de niños: "+BajosTalla1()+"\n"
                                          + "Montería, cantidad de niños: "+BajosTalla2()+"\n"
                                          + "Sahagún, cantidad de niños: "+BajosTalla3());
    }
    
    public int PesoMenor1(){
        nodo info;
        int con = 0;
        if(ListaVacia()){
            JOptionPane.showMessageDialog(null, "La lista está vacía!!!");
        }
        else{
            info = cab;
             do{
                if((info.edad > 1 && info.edad <4) && (info.peso < 15) && (info.munici).equals("Lorica")){
                    con++;
                }
                info = info.sig;
            }while(info != null); 
        }
        return con;
    }
    
    public int PesoMenor2(){
        nodo info;
        int con = 0;
        if(ListaVacia()){
            JOptionPane.showMessageDialog(null, "La lista está vacía!!!");
        }
        else{
            info = cab;
             do{
                if((info.edad > 1 && info.edad <4) && (info.peso < 15) && (info.munici).equals("Montería")){
                    con++;
                }
                info = info.sig;
            }while(info != null); 
        }
        return con;
    }
     
    public int PesoMenor3(){
        nodo info;
        int con = 0;
        if(ListaVacia()){
            JOptionPane.showMessageDialog(null, "La lista está vacía!!!");
        }
        else{
            info = cab;
             do{
                if((info.edad > 1 && info.edad <4) && (info.peso < 15) && (info.munici).equals("Sahagún")){
                    con++;
                }
                info = info.sig;
            }while(info != null); 
        }
        return con;
    }
    
    public void MostarPeso(){
          JOptionPane.showMessageDialog(null, "Reporte de los niños con problemas de peso en cada municipio. \n"
                                          + "Lorica, cantidad de niños: "+PesoMenor1()+"\n"
                                          + "Montería, cantidad de niños: "+PesoMenor2()+"\n"
                                          + "Sahagún, cantidad de niños: "+PesoMenor3());
      }
    public void ListadoLorica(){
        nodo info;
        if(ListaVacia()){
            JOptionPane.showMessageDialog(null, "La Lista está vacía!!!");
        }
        else{
            info = cab;
            String in = "";
            do{
                if((info.munici).equals("Lorica")){
                    in += "INFORMACIÓN DE LOS NIÑOS REGISTRADOS EN LORICA: \n";
                    in += "Registro civil: "+info.civil+"\n";
                    in += "Nombre: "+info.nombre+"\n";
                    in += "Talla: "+info.talla+"\n";
                    in += "Peso: "+info.peso+"\n";
                    in += "Edad: "+info.edad+"\n";
                    in += "Municipio: "+info.munici+"\n";
                    in += "Representante: "+info.nom+"\n";
                    in += "Identificación: "+info.id+"\n";
                }
                info = info.sig;
            }while(info != null);
            in += "Cantidad de niños registrados: "+cont7;
            JOptionPane.showMessageDialog(null, in);
        }
    } 
    
    public void ListadoMonteria(){
        nodo info;
        if(ListaVacia()){
            JOptionPane.showMessageDialog(null, "La Lista está vacía!!!");
        }
        else{
            info = cab;
            String in = "";
            do{
                if((info.munici).equals("Montería")){
                    in += "INFORMACIÓN DE LOS NIÑOS REGISTRADOS EN MONTERÍA: \n";
                    in += "Registro civil: "+info.civil+"\n";
                    in += "Nombre: "+info.nombre+"\n";
                    in += "Talla: "+info.talla+"\n";
                    in += "Peso: "+info.peso+"\n";
                    in += "Edad: "+info.edad+"\n";
                    in += "Municipio: "+info.munici+"\n";
                    in += "Representante: "+info.nom+"\n";
                    in += "Identificación: "+info.id+"\n";
                }
                info = info.sig;
            }while(info != null);
            in += "Cantidad de niños registrados: "+cont8;
            JOptionPane.showMessageDialog(null, in);
        }
    }
    
    public void ListadoSahagun(){
        nodo info;
        if(ListaVacia()){
            JOptionPane.showMessageDialog(null, "La Lista está vacía!!!");
        }
        else{
            info = cab;
            String in = "";
            do{
                if((info.munici).equals("Sahagún")){
                    in += "INFORMACIÓN DE LOS NIÑOS REGISTRADOS EN SAHAGÚN: \n";
                    in += "Registro civil: "+info.civil+"\n";
                    in += "Nombre: "+info.nombre+"\n";
                    in += "Talla: "+info.talla+"\n";
                    in += "Peso: "+info.peso+"\n";
                    in += "Edad: "+info.edad+"\n";
                    in += "Municipio: "+info.munici+"\n";
                    in += "Representante: "+info.nom+"\n";
                    in += "Identificación: "+info.id+"\n";
                }
                info = info.sig;
            }while(info != null);
            in += "Cantidad de niños registrados: "+cont9;
            JOptionPane.showMessageDialog(null, in);
        }
    }
    
    public void MostrarTodos(){
        if(ListaVacia()){
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacía!");
        }
        else{
            nodo q = cab;
            while(q != null){
                q.ShowInfo();
                q = q.sig;
            }
        }
    }
    
}
