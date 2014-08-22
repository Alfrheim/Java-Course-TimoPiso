package logicaNegocio.implementacion;

public class TestInmo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    InmobiliariaUtilidades inm = new InmobiliariaUtilidades();
    ServiciosInmobiliaria a = inm.getDao();
    Object[] b = a.getClientes().toArray();
    for(Object o:b) {
      System.out.println(o);
    }
  }

}
