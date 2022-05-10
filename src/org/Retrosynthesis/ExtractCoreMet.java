package org.Retrosynthesis;
import org.Utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * This extracts core metabolites from a given chassis and store them as a list of unique ID strings
 * @author Y. C. Gao
 */
public class ExtractCoreMet {
    public void initiate() {
    }
    public List<String> run(String metpath) throws Exception{
        List<String> natives = new ArrayList<>();
        String data = FileUtils.readFile(metpath);
        String[] lines = data.trim().split("\\r|\\r?\\n");
        for (int i = 2; i < lines.length; i++) {
            String aCompound = lines[i];
            String[] tabs = aCompound.split(",");
            for (int j = 3; j < tabs.length; j++){
            String chem = tabs[j];
            chem = chem.replaceAll("META:","");
            chem = chem.replaceAll("'","");
            chem = chem.replaceAll("[\\[\\](){}]","");
            chem = chem.replaceAll("^\"|\"$", "");
            chem = chem.replaceAll(" ", "");
            if (!natives.contains(chem)) {
                natives.add(chem);
            }
            }
        }
        return natives;
    }

}