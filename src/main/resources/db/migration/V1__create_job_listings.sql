CREATE TABLE job_listings (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    company VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    source VARCHAR(50) NOT NULL, -- 'LINKEDIN', 'GLASSDOOR', etc.
    source_url VARCHAR(1000) NOT NULL UNIQUE,
    description TEXT,
    salary_min INTEGER,
    salary_max INTEGER,
    is_active BOOLEAN default TRUE,
    posted_at TIMESTAMPTZ,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ
)