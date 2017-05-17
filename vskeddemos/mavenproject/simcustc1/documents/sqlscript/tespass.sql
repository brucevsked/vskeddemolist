-- 将密码改成000000
update sysusert set salt=0xAABB126BAAC5ACFE , `password`= 0x906C9D90CF4BD66EF32EABA2C7A8FD0541CAF7E9 where suName='admin'

-- 将密码改成20131415
update sysusert set salt=0x1AF1C027A423CEF0 , `password`= 0xC51F5E8ABFB1ACFB13EB0468C92FB1A24EEBE03F where suName='admin'