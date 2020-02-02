package challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {

		return (int) this.csvRead().stream()
				.map(Player::getNationality)
				.distinct()
				.count();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {

		return (int) this.csvRead().stream()
				.filter(n -> !n.getClub().isEmpty())
				.map(Player::getClub)
				.distinct()
				.count();
	}

	// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {

		return this.csvRead().stream()
				.map(Player::getFullName)
				.limit(20)
				.collect(Collectors.toList());
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {

		return this.csvRead().stream()
				.filter(p -> !p.getEurReleaseClause().isEmpty())
				.sorted(Comparator.comparingDouble((Player j) -> Double.parseDouble(j.getEurReleaseClause())).reversed())
				.map(Player::getFullName)
				.limit(10)
				.collect(Collectors.toList());
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {

		return this.csvRead().stream()
				.sorted(Comparator.comparing(Player::getBirthDate)
					.thenComparing(Player::getEurWage))
				.map(Player::getFullName)
				.limit(10)
				.collect(Collectors.toList());
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {

		Map<Integer, Long> ageMap = this.csvRead().stream()
				.collect(Collectors.groupingBy((Player p) -> Integer.parseInt(p.getAge()),
						Collectors.counting()));

		Map<Integer, Integer>  finalResult = ageMap
				.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, p -> p.getValue().intValue()));

		return finalResult;
	}

	private static List<Player> csvRead() {

		List<Player>  listPlayer = new ArrayList<>();
		String lineFile = "";
		String lineSplit = ",";

		try {

			BufferedReader bufferedReader = new BufferedReader((new FileReader("/home/mixirica/codenation/java-3/src/main/resources/data.csv")));
			bufferedReader.readLine();

			while( (lineFile = bufferedReader.readLine()) != null ) {

				String[] player = lineFile.split(lineSplit);

				if ( player.length > 0 ) {

					Player addPlayer = new Player();
					addPlayer.setId(player[0]);
					addPlayer.setName(player[1]);
					addPlayer.setFullName(player[2]);
					addPlayer.setClub(player[3]);
					addPlayer.setAge(player[6]);
					addPlayer.setBirthDate(player[8]);
					addPlayer.setNationality(player[14]);
					addPlayer.setEurWage(player[17]);
					addPlayer.setEurReleaseClause(player[18]);
					listPlayer.add(addPlayer);
				}
			}

		} catch(IOException e) {
			e.getMessage();
		}
		return listPlayer;
	}
}