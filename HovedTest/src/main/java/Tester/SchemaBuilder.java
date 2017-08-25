package Tester;

import java.util.HashMap;
import javax.persistence.Persistence;

public class SchemaBuilder {
    
    public static void main(String[] args) {
        
        
        HashMap pu = new HashMap();
        pu.put("javax.persistence.sql-load-script-source", "scripts/createDb.sql");
        Persistence.generateSchema("jpaPU", pu);
        pu.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("jpaPU", pu);
    }
}
