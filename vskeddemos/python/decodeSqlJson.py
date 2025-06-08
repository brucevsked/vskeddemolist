import re
import json

def process_sql_line(sql_line):
    # 正则表达式匹配特定格式的字段
    pattern = r'\[(\d+(?:\s+\d+)*)\]'

    def convert_to_json(match):
        numbers = list(map(int, match.group(1).split()))
        data_dict = {f"res{i+1}": num for i, num in enumerate(numbers)}
        json_data = json.dumps(data_dict)
        return f"'{json_data}'"

    # 替换原始SQL语句中的字段
    new_sql_line = re.sub(pattern, convert_to_json, sql_line)

    return new_sql_line

def process_sql_file(input_file, output_file):
    with open(input_file, 'r', encoding='utf-8') as infile, open(output_file, 'w', encoding='utf-8') as outfile:
        for line in infile:
            new_line = process_sql_line(line)
            outfile.write(new_line)

# 处理文件
input_file = 'blade_face_records.sql'
output_file = 'blade_face_records_fixed.sql'
process_sql_file(input_file, output_file)

print(f"处理完成，新的SQL语句已写入 {output_file} 文件中")