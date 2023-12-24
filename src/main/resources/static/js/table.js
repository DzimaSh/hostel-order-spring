function handleRowClick(orderId, isAdmin = false) {
    const url = '/orders/' + orderId;
    window.location.href = isAdmin
        ? `/admin${url}/approve`
        : url;
}
