function handleRowClick(orderId, isAdmin = false) {
    const url = '/orders/details/' + orderId;
    window.location.href = isAdmin
        ? `/admin${url}`
        : url;
}
