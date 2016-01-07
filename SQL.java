package DataBases;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class SQL {
    
    static public Vector consulta(String sql){
        Vector regs = new Vector();

        try	{
            Conexion 		db = new Conexion();//Llamamos a nuestra Clase Conexion
            Connection		cn = db.getConnection();

            if (cn == null) {
            	regs = null;
            } else {
	            Statement  		st = cn.createStatement();
	            ResultSet		rs = st.executeQuery(sql);
	            ResultSetMetaData	rm = rs.getMetaData();
	            int 		numCols = rm.getColumnCount();

	            // Toma los títulos de las columnas
	            String[] titCols= new String[numCols];
	            for(int i=0; i<numCols; ++i)//recorre las filas de la Tabla
	                titCols[i]= rm.getColumnName(i+1);

	            // la fila 0 del vector lleva los títulos de las columnas
	            regs.add(titCols);

	            // toma las filas de la consulta
	            while(rs.next()) {
	                String[] reg= new String[numCols];

	                for(int i=0; i<numCols; i++) {
	                    reg[i] = rs.getString(i + 1);
	                }

	                regs.add(reg);
	            }

	            rs.close();
	            st.close();
	            cn.close();
            }

        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return regs;
    }

    // Retorna una sola fila
    static public String[] getFila(String sql)
    {
        Vector vector = consulta(sql);
        String[] fila = null;

        if(vector!=null)				// todo OK!
            if(vector.size()>1)				// hay filas
                fila = (String[]) vector.get(1);	// en 0 están los títulos

        return fila;
    }

    // Retorna un solo campo
    static public String getCampo(String sql) {
        String[] fila = getFila(sql);
        String campo = null;

        if(fila!=null)		// hay campo
            campo = fila[0];

        return campo;
    }
/*********************************************************************************************/
/*********************************************************************************************/
    
    
    static public int error_code(String sql)
    {
        int number;
        try
        {
            Conexion 	db = new Conexion();//Llamamos a nuestra Clase Conexion
            Connection	cn = db.getConnection();

            if (cn == null) {
                //si number = 1, no existe conexion
            	number = 1;
            } else {
            	Statement st = cn.createStatement();//Obtiene procedimiento o consulta
            	st.execute(sql);//Ejecuta Consulta
            	st.close();
            	cn.close();
                //si number = 2, SQL is ok..
                
                number = 2;
            }
        } catch(SQLException e)	{
            
            number = e.getErrorCode();
        }
        catch(Exception e) {
            number = 3; 
        }
        
        
        

        return number;
    }
    /*********************************************************************************************/
    /*********************************************************************************************/
    
/*********************************************************************************************/
/*********************************************************************************************/
    
    
    static public String execute_query(String sql)
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
                
                mensaje = "true";
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
            	ResultSet	rs = st.executeQuery(sql);//Ejecuta Consulta
                
                
                flag = rs.first();
                
                rs.close();
            	st.close();
            	cn.close();
               
                
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
     
     
    /*********************************************************************************************/
    /*********************************************************************************************/
    
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
    
    /*********************************************************************************************/
    /*********************************************************************************************/
    
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
    
    /*********************************************************************************************/
    static public JSONArray get_records(String sql){
        ArrayList a = new ArrayList();
        JSONArray json = new JSONArray();
        
        try {
            Conexion 	db = new Conexion();
            Connection	cn = db.getConnection();
            
            if (cn == null) {
            	a = null;
            }
            else {
                
                Statement           st = cn.createStatement();
                ResultSet           rs = st.executeQuery(sql);
                ResultSetMetaData	rsmd = rs.getMetaData();
                
                int numCols = rsmd.getColumnCount();
                rs.last();
                int numFils = rs.getRow();
                
                
                String []nomCampos = new String[numCols];
                
                for(int i=0; i<nomCampos.length; i++) {
                    nomCampos[i]= rsmd.getColumnName(i+1);
                }
                
                rs.beforeFirst();
                
                
                while(rs.next()) {
                    int numColumns = rsmd.getColumnCount();
                    JSONObject obj = new JSONObject();
                    
                    
                    for (int i=1; i<numColumns+1; i++) {
                        String column_name = rsmd.getColumnName(i);
                        
                        obj.put(column_name, rs.getString(column_name));
                    }
                    json.put(obj);
                }
                
                
                
                
                
            }
            
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return json;
    }
    
    
    static public ArrayList get_records2(String sql){
        ArrayList a = new ArrayList();
        JSONArray json = new JSONArray();
        
        try {
            Conexion 	db = new Conexion();
            Connection	cn = db.getConnection();
            
            if (cn == null) {
            	a = null;
            }
            else {
                
                Statement           st = cn.createStatement();
                ResultSet           rs = st.executeQuery(sql);
                ResultSetMetaData	rsmd = rs.getMetaData();
                
                int numCols = rsmd.getColumnCount();
                rs.last();
                int numFils = rs.getRow();
                
                
                String []nomCampos = new String[numCols];
                JSONObject obj = new JSONObject();
                
                for(int i=0; i<nomCampos.length; i++) {
                    nomCampos[i]= rsmd.getColumnName(i+1);
                }
                
                rs.beforeFirst();
                
                
                while(rs.next()) {
                    int numColumns = rsmd.getColumnCount();
                    for (int i=1; i<numColumns+1; i++) {
                        String column_name = rsmd.getColumnName(i);
                        a.add(rs.getString(column_name));
                        
                        //json.put(rs.getString(column_name));
                    }
                }
            
            }
            
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return a;
    }
    /*********************************************************************************************/
    
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
     
     static public ArrayList get_locations(String sql){
        ArrayList a = new ArrayList();
        
        try {
            Conexion 	db = new Conexion();
            Connection	cn = db.getConnection();
            
            if (cn == null) {
            	a = null;
            }
            else {
                
                Statement  	st = cn.createStatement();
                ResultSet	rs = st.executeQuery(sql);
                ResultSetMetaData	rm = rs.getMetaData();
                
                int numCols = rm.getColumnCount();
                
                
                for(int i=0; i<numCols; ++i) {
                    a.add(rm.getColumnName(i+1));
                }
                
                
                
                
            }
            
        }
        
        catch(Exception e) {
            a = null;
        }
        
        return a;
    }
     static public JSONObject generateJsonSQL(String sql){
         JSONObject myjson = new JSONObject();
         
         try {
            Conexion 	db = new Conexion();
            Connection	cn = db.getConnection();
            
            if (cn == null) {
            	myjson = null;
            }
            else {
                
                Statement           st = cn.createStatement();
                ResultSet           rs = st.executeQuery(sql);
                ResultSetMetaData	rsmd = rs.getMetaData();
                
                int numCols = rsmd.getColumnCount();
                rs.last();
                int numFils = rs.getRow();
                
                
                String []nomCampos = new String[numCols];
                
                for(int i=0; i<nomCampos.length; i++) {
                    nomCampos[i]= rsmd.getColumnName(i+1);
                }
                
                rs.beforeFirst();
                
                for (int i=1; i<numCols+1; i++) {
                
                String column_name = rsmd.getColumnName(i);
                myjson.put(column_name, rs.getString(column_name));
                }
                
            }
         }
            catch(Exception e){
            myjson = null;
            }
         myjson.toString();
         return myjson;
     }
}
