-- Trigger ve xe
DELIMITER //
CREATE TRIGGER check_ve_xe_limit
BEFORE INSERT ON ve_xe
FOR EACH ROW
BEGIN
    DECLARE sv_count INT;
    SELECT COUNT(*) INTO sv_count FROM ve_xe WHERE ma_sv = NEW.ma_sv;
    IF sv_count > 1 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Moi sinh vien chi duoc dang ky gui toi da 2 xe ve thang!';
    END IF;
END;
//
DELIMITER ;


-- Trigger so nguoi trong phong
DELIMITER //

CREATE TRIGGER check_hop_dong_constraint
BEFORE INSERT ON hop_dong
FOR EACH ROW
BEGIN
    DECLARE sv_count INT;
    SELECT so_SV_hien_co INTO sv_count
    FROM phong
    WHERE ten_ky_tuc_xa = NEW.ten_ktx
    AND ten_phong = NEW.ten_phong;
    IF sv_count >= (
        SELECT so_SV_toi_da
        FROM loai_phong
        WHERE ma_loai_phong = (
            SELECT ma_loai_phong
            FROM phong
            WHERE ten_ky_tuc_xa = NEW.ten_ktx
            AND ten_phong = NEW.ten_phong
        )
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Vi pham rang buoc: So luong sinh vien hien co vuot qua gioi han cho phong nay';
    END IF;
END;
//

DELIMITER ;


-- Trigger them ve xe
DELIMITER //

CREATE TRIGGER check_ve_xe_contract
BEFORE INSERT ON ve_xe
FOR EACH ROW
BEGIN
    DECLARE contract_end_date DATE;
        SELECT ngay_ket_thuc INTO contract_end_date
    FROM hop_dong
    WHERE ma_sv = NEW.ma_sv;

    IF contract_end_date < CURDATE() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Hợp đồng của sinh viên đã hết hạn. Không thể thêm vé xe.';
    END IF;
END;
//

DELIMITER ;


-- Trigger them luot tham
DELIMITER //

CREATE TRIGGER check_luot_tham_contract
BEFORE INSERT ON luot_tham
FOR EACH ROW
BEGIN
    DECLARE contract_end_date DATE;
    SELECT ngay_ket_thuc INTO contract_end_date
    FROM hop_dong
    WHERE ma_sv = NEW.ma_sv;
    IF contract_end_date < CURDATE() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Hợp đồng của sinh viên đã hết hạn. Không thể thêm lượt thăm.';
    END IF;
END;
//

DELIMITER ;


-- Trigger lan giat
DELIMITER //

CREATE TRIGGER check_lan_giat_contract
BEFORE INSERT ON lan_giat
FOR EACH ROW
BEGIN
    DECLARE contract_end_date DATE;
    SELECT ngay_ket_thuc INTO contract_end_date
    FROM hop_dong
    WHERE ma_sv = NEW.ma_sv;
    IF contract_end_date < CURDATE() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Hợp đồng của sinh viên đã hết hạn. Không thể thêm lần giặt.';
    END IF;
END;
//

DELIMITER ;


-- Trigger khi them lan gui xe
DELIMITER //

CREATE TRIGGER check_lan_gui_xe_contract
BEFORE INSERT ON lan_gui_xe
FOR EACH ROW
BEGIN
    DECLARE contract_end_date DATE;
    SELECT ngay_ket_thuc INTO contract_end_date
    FROM hop_dong
    WHERE ma_sv = NEW.ma_sv;
    IF contract_end_date < CURDATE() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Hợp đồng của sinh viên đã hết hạn. Không thể thêm lần gửi xe.';
    END IF;
END;
//

DELIMITER ;


-- Trigger khi them hop dong
DELIMITER //

CREATE TRIGGER check_hop_dong
BEFORE INSERT ON hop_dong
FOR EACH ROW
BEGIN
    DECLARE is_valid INT;
    
    SELECT COUNT(*) INTO is_valid
    FROM hop_dong
    WHERE ma_sv = NEW.ma_SV
    AND CURDATE() BETWEEN ngay_bat_dau AND ngay_ket_thuc;

    IF is_valid > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Sinh viên đã có hợp đồng hiện tại. Không thể thêm hợp đồng mới.';
    END IF;
END;
//

DELIMITER ;




