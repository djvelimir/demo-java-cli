# demo-java-cli

## Password Generator Application

Welcome to the Password Generator Application! This tool is designed to help users effortlessly create secure passwords that are 16 characters long. It will create a unique combination of uppercase letters, lowercase letters, numbers, and special symbols to ensure strong security, making it suitable for protecting sensitive accounts and personal information. The generated password will comply with best practices for complexity and randomness, eliminating the need for users to create their own passwords while enhancing their online safety. Whether you're setting up a new account, enhancing your cybersecurity, or simply in need of a reliable password, this solution has got you covered. No additional options or complex settings are necessary; just generate and use your password with confidence! The code is open-source, inviting contributions and modifications from the community to enhance functionality while keeping safety at the forefront. Start protecting your digital life today with our Password Generator Application!

## Use Case Diagram

A use case diagram for a password generator application illustrates the interactions between users and the system. The "Generate Password" use case allows users to create secure, random passwords.

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="http://www.plantuml.com/plantuml/proxy?cache=no&fmt=svg&src=https://raw.githubusercontent.com/djvelimir/demo-java-cli/main/diagrams/UseCase_dark.puml">
  <img alt="Use Case Diagram" src="http://www.plantuml.com/plantuml/proxy?cache=no&fmt=svg&src=https://raw.githubusercontent.com/djvelimir/demo-java-cli/main/diagrams/UseCase.puml">
</picture>

## Sequence Diagram

In a sequence diagram for a password generator application, the user initiates the process by launching the CLI application with the command to generate a password. The application triggers the password generation function. This function then systematically ensures that the generated password contains at least one lowercase letter, one uppercase letter, one number, and one special symbol, employing randomization to meet these criteria. Once the password is successfully generated, the application returns the secure password to the user, completing the interaction seamlessly without requiring any additional settings.

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="http://www.plantuml.com/plantuml/proxy?cache=no&fmt=svg&src=https://raw.githubusercontent.com/djvelimir/demo-java-cli/main/diagrams/Sequence_dark.puml">
  <img alt="Sequence Diagram" src="http://www.plantuml.com/plantuml/proxy?cache=no&fmt=svg&src=https://raw.githubusercontent.com/djvelimir/demo-java-cli/main/diagrams/Sequence.puml">
</picture>

## Class Diagram

The class diagram for a CLI password generator application outlines a system that automates the creation of secure passwords. At its core, the generator utilizes an algorithm that ensures each password includes at least one lowercase letter, one uppercase letter, one numeral, and one special character. The password generation process randomly selects characters from predefined sets corresponding to each required category. The system outputs a strong password without requiring any user input, enhancing convenience while ensuring security standards are met.

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="http://www.plantuml.com/plantuml/proxy?cache=no&fmt=svg&src=https://raw.githubusercontent.com/djvelimir/demo-java-cli/main/diagrams/Class_dark.puml">
  <img alt="Class Diagram" src="http://www.plantuml.com/plantuml/proxy?cache=no&fmt=svg&src=https://raw.githubusercontent.com/djvelimir/demo-java-cli/main/diagrams/Class.puml">
</picture>
