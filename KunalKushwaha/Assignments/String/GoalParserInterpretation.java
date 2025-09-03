package KunalKushwaha.Assignments.String;

public class GoalParserInterpretation {
    public String interpret(String command) {
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < command.length(); i++){
            switch(command.charAt(i)){
                case 'G':
                    output.append('G');
                    break;
                case '(':
                    if(command.charAt(i + 1) ==')'){
                        output.append('o');
                        i++;
                    }else{
                        output.append('a');
                        output.append('l');
                        i +=3;
                    }
            }
        }

        return output.toString();
    }
}
