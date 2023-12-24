function calculateTotalRent() {
    const selectedRooms = document.getElementById('selectedRooms');
    let totalRent = 0;

    console.log(selectedRooms.options);
    for (let i = 0; i < selectedRooms.options.length; i++) {
        if (selectedRooms.options[i].selected) {
            totalRent += extractAmountFromString(selectedRooms.options[i].text);
        }
    }

    document.getElementById('totalRent').textContent = totalRent.toFixed(2);
}

function extractAmountFromString(inputString) {
    const parts = inputString.split('-');
    const lastPart = parts[parts.length - 1].trim();
    const amountString = lastPart.substring(0, lastPart.indexOf('c.u.')).trim();

    return parseFloat(amountString);
}

calculateTotalRent();
