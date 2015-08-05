

import java.sql.*;

public class SQL1 {
    
    static public String exect_string(String sql)
    {
        String mensaje= null;
        try
        {
            Conexion 	db = new Conexion();//Llamamos a nuestra Clase Conexion
            Connection	cn = db.getConnection();

            if (cn == null) {
            	mensaje = "No hay conexión a la base de datos...!";
            } else {
            	Statement st = cn.createStatement();//Obtiene procedimiento o consulta
            	st.execute(sql);//Ejecuta Consulta
            	st.close();
            	cn.close();
            }
        } catch(SQLException e)	{
            mensaje= e.getMessage();
        } catch(Exception e) {
            mensaje= e.getMessage();
        }

        return mensaje;
    }
    /*********************************************************************************************/
    /*********************************************************************************************/
    
    static public boolean exect_bool(String sql)
    {
        boolean flag = false;
        
        String mensaje= null;
        try
        {
            Conexion 	db = new Conexion();//Llamamos a nuestra Clase Conexion
            Connection	cn = db.getConnection();

            if (cn == null) {
            	flag = false;
                return flag;
            } else {
            	Statement st = cn.createStatement();//Obtiene procedimiento o consulta
            	st.execute(sql);//Ejecuta Consulta
            	st.close();
            	cn.close();
                flag = true;
                return flag;
            }
        } catch(SQLException e)	{
            mensaje= e.getMessage();
        } catch(Exception e) {
            mensaje= e.getMessage();
        }
        return flag;
    }
    
    /*********************************************************************************************/
    /*********************************************************************************************/
     static public String[] column_names(String sql)
    {
        String[] cols = null;
        
        try
        {
            Conexion 	db = new Conexion();//Llamamos a nuestra Clase Conexion
            Connection	cn = db.getConnection();

            if (cn == null) {
            	cols = null;
            }
            else {
                Statement  	st = cn.createStatement();
                ResultSet	rs = st.executeQuery(sql);
                ResultSetMetaData	rm = rs.getMetaData();
                
                int numCols = rm.getColumnCount();
                
                cols = new String[numCols];
                
                for(int i=0; i<numCols; ++i) {
                    cols[i]= rm.getColumnName(i+1);
                }
           
            	st.close();
            	cn.close();
                
            }
        } catch(SQLException e)	{
            cols = null;
        } catch(Exception e) {
            cols = null;
        }
        
        
        return cols;
    }
     
     
    
    static public String[] table_names(String sql)
    {
        String[] tables = null;
        
        try
        {
            Conexion 	db = new Conexion();//Llamamos a nuestra Clase Conexion
            Connection	cn = db.getConnection();

            if (cn == null) {
            	tables = null;
            }
            else {
                Statement  	st = cn.createStatement();
                ResultSet	rs = st.executeQuery(sql);
                ResultSetMetaData	rm = rs.getMetaData();
                
                int numCols = rm.getColumnCount();
                
                tables = new String[numCols];
                
                for(int i=0; i<numCols; ++i) {
                    tables[i]= rm.getTableName(i+1);
                }
           
            	st.close();
            	cn.close();
                
            }
        } catch(SQLException e)	{
            tables = null;
        } catch(Exception e) {
            tables = null;
        }
        
        
        return tables;
    }
    
    
    static public String[] column_types(String sql)
    {
        String[] columns = null;
        
        try
        {
            Conexion 	db = new Conexion();//Llamamos a nuestra Clase Conexion
            Connection	cn = db.getConnection();

            if (cn == null) {
            	columns = null;
            }
            else {
                Statement  	st = cn.createStatement();
                ResultSet	rs = st.executeQuery(sql);
                ResultSetMetaData	rm = rs.getMetaData();
                
                int numCols = rm.getColumnCount();
                
                columns = new String[numCols];
                
                for(int i=0; i<numCols; ++i) {
                    columns[i]= rm.getColumnTypeName(i+1);
                }
           
            	st.close();
            	cn.close();
                
            }
        } catch(SQLException e)	{
            columns = null;
        } catch(Exception e) {
            columns = null;
        }
        
        
        return columns;
    }
    
    
     static public String[][] rows(String sql) {
         
         String[][] matriz = null;
        
        try
        {
            Conexion 	db = new Conexion();//Llamamos a nuestra Clase Conexion
            Connection	cn = db.getConnection();

            if (cn == null) {
            	matriz = null;
            }
            else {
                
                Statement           st = cn.createStatement();
                ResultSet           rs = st.executeQuery(sql);
                ResultSetMetaData	rsmd = rs.getMetaData();
                
                int numCols = rsmd.getColumnCount();
                rs.last();
                int numFils = rs.getRow();
                
                matriz = new String[numFils][numCols];
                String []nomCampos = new String[numCols];
                
                
                for(int i=0; i<nomCampos.length; i++) {
                    nomCampos[i]= rsmd.getColumnName(i+1);
                }
           
                rs.beforeFirst();
                for(int f=0; f < numFils; f++) {
                    rs.next();
                    for(int c=0; c < numCols; c++) {
                        matriz[f][c] = rs.getString(nomCampos[c]);
                    }
                }
                st.close();
            	cn.close();
            }
        } catch(SQLException e)	{
            matriz = null;
        } catch(Exception e) {
            matriz = null;
        }
        
        
        return matriz;
    }
     
     
     
}
