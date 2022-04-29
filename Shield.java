import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Shield {

	public static void main(String[] args)
	{

		List<String> names = new ArrayList<>();
		names.add("Phil Coulson");
		names.add("Melinda May");
		names.add("Daisy Johnson");
		names.add("Leopold Fitz");
		names.add("Jemma Simmons");

		// TODO 1 : map names to agents list

		Function<String, Agent> dissociateAgentName = agentNamesNotDissociated ->  {
			String[] splittedString = agentNamesNotDissociated.split(" ");
			String lastName = splittedString[1];
			String firstName = splittedString[0];
			Agent agent = new Agent("", "");
			agent.setLastName(lastName);
			agent.setFirstName(firstName);
			return agent;
		};

		List<Agent> agents = new ArrayList<>();
		agents = names.stream().map(n -> dissociateAgentName.apply(n)).collect(Collectors.toList());
		showAgents(agents);

	}

    // don't touch anything here !
    private static void showAgents(List<Agent> agents) {
        System.out.println("\nAgents:");
        for (Agent agent : agents) {
            System.out.println(agent.getLastName() + " " + agent.getFirstName());
        }
    }
}