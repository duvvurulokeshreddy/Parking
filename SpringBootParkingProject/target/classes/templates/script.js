document.addEventListener('DOMContentLoaded', function() {
    if (!isLoggedIn()) {
        window.location.href = '/login.html';
    } else {
        fetchAvailableSlots();
    }
});

function isLoggedIn() {
    // Add logic to check if the user is logged in
    // For simplicity, you can use cookies or localStorage
    return !!localStorage.getItem('username');
}

function fetchAvailableSlots() {
    fetch('/api/parkingslots/available')
        .then(response => response.json())
        .then(slots => {
            const container = document.getElementById('available-slots');
            container.innerHTML = '';
            slots.forEach(slot => {
                const slotElement = document.createElement('div');
                slotElement.className = 'slot';
                slotElement.innerHTML = `
                    <span>Slot: ${slot.id}</span>
                    <button onclick="bookSlot(${slot.id})">Book</button>
                `;
                container.appendChild(slotElement);
            });
        });
}

function bookSlot(id) {
    fetch(`/api/parkingslots/book/${id}`, {
        method: 'POST'
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Failed to book slot');
        }
    })
    .then(slot => {
        alert(`Slot ${slot.id} booked successfully!`);
        fetchAvailableSlots();
    })
    .catch(error => {
        alert(error.message);
    });
}
