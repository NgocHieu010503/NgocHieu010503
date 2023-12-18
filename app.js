document.addEventListener('DOMContentLoaded', function () {
    const openFormBtn = document.getElementById('openFormBtn');
    const closeFormBtn = document.getElementById('closeFormBtn');
    const submitFormBtn = document.getElementById('submitFormBtn');
    const donThuocForm = document.getElementById('donThuocForm');
    const donThuocList = document.getElementById('donThuocList');

    openFormBtn.addEventListener('click', function () {
        donThuocForm.style.display = 'flex';
    });

    closeFormBtn.addEventListener('click', function () {
        donThuocForm.style.display = 'none';
    });

    submitFormBtn.addEventListener('click', function () {
        themDonThuoc();
    });

    function themDonThuoc() {
        const ngayKeDon = document.getElementById('ngayKeDon').value;
        const tenBenhNhan = document.getElementById('tenBenhNhan').value;
        const danhSachThuoc = document.getElementById('danhSachThuoc').value.split(',');

        const donThuoc = {
            ngayKeDon: ngayKeDon,
            tenBenhNhan: tenBenhNhan,
            danhSachThuoc: danhSachThuoc
        };

        hienThiDonThuoc(donThuoc);
        resetForm();
        donThuocForm.style.display = 'none';
    }

    function hienThiDonThuoc(donThuoc) {
        const li = document.createElement('li');
        li.innerHTML = `<strong>Ngày kê đơn:</strong> ${donThuoc.ngayKeDon}<br>
                        <strong>Bệnh nhân:</strong> ${donThuoc.tenBenhNhan}<br>
                        <strong>Danh sách thuốc:</strong> ${donThuoc.danhSachThuoc.join(', ')}`;
        donThuocList.appendChild(li);
    }

    function resetForm() {
        document.getElementById('ngayKeDon').value = '';
        document.getElementById('tenBenhNhan').value = '';
        document.getElementById('danhSachThuoc').value = '';
    }
});
