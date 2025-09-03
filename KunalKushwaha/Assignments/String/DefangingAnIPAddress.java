package KunalKushwaha.Assignments.String;

public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder defangAddress = new StringBuilder(address);

        for(int i = 0; i < defangAddress.length(); i++){
            if(defangAddress.charAt(i) == '.'){
                defangAddress.replace(i, i + 1 ,"[.]");
                i = i + 3;
            }
        }

        return defangAddress.toString();
    }

    public static void main(String[] args) {
        DefangingAnIPAddress q = new DefangingAnIPAddress();

        System.out.println(q.defangIPaddr("255.100.50.0"));
    }
}
