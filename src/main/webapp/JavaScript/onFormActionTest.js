
// TO JEST NIE POTRZEBNE ZOSTAJE DLA POTOMNYCH :D

function formAction() {
    var login = document.getElementById("login").value;
    var haslo = document.getElementById("haslo").value;
    var email = document.getElementById("email").value;
    var weryfikacja = document.getElementsByName("weryfikacja");
    weryfikacja = weryfikacja[0].checked;

    /*document.writeln(login);
    document.writeln(haslo);
    document.writeln(email);
    document.writeln(weryfikacja);
*/
}
