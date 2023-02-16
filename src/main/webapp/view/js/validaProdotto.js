function validateNewProduct(){
    var nomeProdotto = document.getElementById('nomeProdotto').value;
    var nomeProdottoRGX=/^[a-zA-Z0-9]*$/;
    var descrizioneProdotto = document.getElementById('descrizioneProdotto').value;
    var descrizioneRGX = /^[a-zA-Z0-9' '+,.°*-]*$/;
    var prezzoVendita = document.getElementById('prezzoVendita').value;
    var prezzoVenditaRGX = /^[0-9.]*$/;
    var prezzoAcquisto = document.getElementById('prezzoAcquisto').value;
    var prezzoAcquistoRGX = /^[0-9.]*$/;
    var tipologiaVendita = document.getElementById('tipologiaVendita').value;
    var tipologiaVenditaRGX = /^[a-zA-Z]*$/;

    if(nomeProdottoRGX.test(nomeProdotto)==false){
        alert("Errore formato nome non valido!");
        return false;
    }

    if(nomeProdotto.length>30) {
        alert("Errore lunghezza del nome elevata!");
        return false;
    }

    if(descrizioneRGX.test(descrizioneProdotto)==false){
        alert("Errore descrizione non valida!");
        return false;
    }

    if(prezzoVenditaRGX.test(prezzoVendita)==false){
        alert("Errore formato del prezzo di vendita non valido!");
        return false;
    }

    if(prezzoAcquistoRGX.test(prezzoAcquisto)==false){
        alert("Errore formato del prezzo di acquisto non valido!");
        return false;
    }

    if(tipologiaVenditaRGX.test(tipologiaVendita)==false){
        alert("Errore formato tipologia non valido!");
        return false;
    }

    if(tipologiaVendita.length>10){
        alert("Errore lunghezza di tipologiaVendita non valida!");
        return false;
    }
    return true;
}