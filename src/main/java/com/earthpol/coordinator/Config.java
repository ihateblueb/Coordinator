package com.earthpol.coordinator;

import com.sun.tools.javac.util.List;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

	public final static FileConfiguration file = Main.instance.getConfig();

	public static void initialize() {
		file.options().setHeader(
				List.of(
						"Coordinator Configuration",
						"https://earthmc.org/docs/plugins/coordinator/",
						"",
						"Configure tiles and scale based on the following table:",
						"Ratio		Scale		Tiles",
						"1:108		15360		15",
						"1:217		7680		15",
						"1:326		5120		15",
						"1:543		3072		15"
				)
		);



		file.addDefault(
				"scale",
				""
		);
		file.setComments(
				"scale",
				List.of(
						"Blocks per tile"
				)
		);


		file.addDefault(
				"tiles",
				""
		);
		file.setComments(
				"tiles",
				List.of(
						"Degrees per tile"
				)
		);



		file.addDefault(
				"message.coordinate.default",

				"<dark_gray><s>----</s>=<s>----</s> <yellow>In-game Coordinates</yellow> <dark_gray><s>----</s>=<s>----</s>\n"
				+"<gray>X: <yellow>{x} <gray>Z: <yellow>{z}\n"
				+"<i><gray><click:copy_to_clipboard:'{x} 255 {z}'>Click to copy coordinates</click>"
		);
		file.setComments(
				"message.coordinate.default",
				List.of(
						"Message to sent in response to /coordinate.",
						"",
						"Placeholders:",
						"{x} - converted x coordinate",
						"{z} - converted z coordinate"
				)
		);

		file.addDefault(
				"message.coordinate.admin",

				"\n<i><gray><click:copy_to_clipboard:'{x} 255 {z}'>Click to teleport</click>"
		);
		file.setComments(
				"message.coordinate.admin",
				List.of(
						"Additional lines to append to coordinate command response if the sender is an admin."
				)
		);



		file.addDefault(
				"message.getlocation.default",

				"<dark_gray><s>----</s>=<s>----</s> <yellow>Real World Coordinates</yellow> <dark_gray><s>----</s>=<s>----</s>\n"
						+"<gray>X: <yellow>{x} <gray>Y: <yellow>{y} <gray>Z: <yellow>{z}\n"
						+"<gray>Lat: <yellow>{lat} <gray>Long: <yellow>{long}\n"
						+"<i><gray><click:copy_to_clipboard:'{lat} {long}'>Click to copy coordinates</click>\n"
						+"<i><gray><click:open_url:'https://www.google.com/maps/@{lat},{long},18z'>Click to open Google Maps/click>"
		);
		file.setComments(
				"message.getlocation.default",
				List.of(
						"Message to sent in response to /getlocation.",
						"",
						"Placeholders:",
						"{lat} - converted latitude",
						"{long} - converted longitude",
						"{x} - player x coordinate",
						"{y} - player y coordinate",
						"{z} - player z coordinate"
				)
		);


		file.addDefault(
				"message.error.latlongnumber",
				"<red>Latitude and longitude should be a number"
		);
		file.addDefault(
				"message.error.incorrectusage",
				"<red>Incorrect usage! /coordinate <latitude> <longitude>"
		);

		file.options().parseComments();
		file.options().copyDefaults(true);
		Main.instance.saveConfig();
	}

}
