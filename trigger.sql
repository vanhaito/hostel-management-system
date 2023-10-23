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
